/**
 * @file 工具包
 * @author dj(1193933@qq.com)
 */

'use strict';

const path = require('path');
const config = require('../config');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const fs = require('fs');

exports.assetsPath = function (newPath) {
    let assetsSubDirectory = process.env.NODE_ENV === 'production'
        ? config.build.assetsSubDirectory
        : config.dev.assetsSubDirectory;

    return path.posix.join(assetsSubDirectory, newPath);
};

exports.cssLoaders = function (options) {
    options = options || {};

    let cssLoader = {
        loader: 'css-loader',
        options: {
            minimize: process.env.NODE_ENV === 'production',
            sourceMap: options.sourceMap
        }
    };

    let px2remLoader = {
        loader: 'px2rem-loader',
        options: {
            remUnit: 41.4
        }
    }

    let autoprefixer = {
        loader: 'autoprefixer-loader',
        options: {
            minimize: process.env.NODE_ENV === 'production',
            sourceMap: options.sourceMap
        }
    }

    // generate loader string to be used with extract text plugin
    function generateLoaders(loader, loaderOptions) {
        let loaders = [cssLoader, px2remLoader, autoprefixer];
        if (loader) {
            loaders.push({
                loader: loader + '-loader',
                options: Object.assign({}, loaderOptions, {
                    sourceMap: options.sourceMap
                })
            });
        }

        // Extract CSS when that option is specified
        // (which is the case during production build)
        if (options.extract) {
            return ExtractTextPlugin.extract({
                use: loaders,
                fallback: 'vue-style-loader'
            });
        }

        return ['vue-style-loader'].concat(loaders);
    }

    function getLessVariables(file) {
        var themeContent = fs.readFileSync(file, 'utf-8')
        var variables = {}
        themeContent.split('\n').forEach(function (item) {
            if (item.indexOf('//') > -1 || item.indexOf('/*') > -1) {
                return
            }
            var _pair = item.split(':')
            if (_pair.length < 2) return;
            var key = _pair[0].replace('\r', '').replace('@', '')
            if (!key) return;
            var value = _pair[1].replace(';', '').replace('\r', '').replace(/^\s+|\s+$/g, '')
            variables[key] = value
        })
        return variables
    }

    // https://vue-loader.vuejs.org/en/configurations/extract-css.html
    return {
        css: generateLoaders(),
        postcss: generateLoaders(),
        less: generateLoaders('less', {
            globalVars: getLessVariables(config.themePath)
        }),
        sass: generateLoaders('sass', { indentedSyntax: true }),
        scss: generateLoaders('sass'),
        stylus: generateLoaders('stylus'),
        styl: generateLoaders('stylus')
    };
};

// Generate loaders for standalone style files (outside of .vue)
exports.styleLoaders = function (options) {
    let output = [];
    let loaders = exports.cssLoaders(options);

    Object.keys(loaders).forEach(function (extension) {
        let loader = loaders[extension];
        output.push({
            test: new RegExp('\\.' + extension + '$'),
            use: loader
        });
    });
    return output;
};
