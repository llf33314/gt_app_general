/**
 * @file client entry
 * @author dj(1193933@qq.com)
 */

import 'babel-polyfill';
import FastClick from 'fastclick';
import { createApp } from './app';

FastClick.attach(document.body);

let { app, router } = createApp();

router.onReady(() => app.$mount('#app'));
