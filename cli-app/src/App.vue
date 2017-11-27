<template>
  <div id="app">
    <mt-header :title="pageTitle" :fixed="true">
      <router-link to="" slot="left" v-if="isBackShow" @click.native="backPages">
        <mt-button icon="back"></mt-button>
      </router-link>
      <mt-button icon="more" slot="right" @click.native="morePages"></mt-button>
    </mt-header>
    <router-view class="router-content" />
    <mt-tabbar v-model="selected" :fixed="true">
      <mt-tab-item id="Index" @click.native="switchPages(0)">
        <img slot="icon" src="/static/img/favicon.ico"> 首页
      </mt-tab-item>
      <mt-tab-item id="Classify" @click.native="switchPages(1)">
        <img slot="icon" src="/static/img/favicon.ico"> 分类
      </mt-tab-item>
      <mt-tab-item id="Find" @click.native="switchPages(2)">
        <img slot="icon" src="/static/img/favicon.ico"> 发现
      </mt-tab-item>
      <mt-tab-item id="User" @click.native="switchPages(3)">
        <img slot="icon" src="/static/img/favicon.ico"> 用户
      </mt-tab-item>
    </mt-tabbar>
  </div>
</template>
<script>
import { Toast } from 'mint-ui';
export default {
  name: "app",
  data() {
    return {
      selected: "Index",
      pageTitle: "首页",
      isBackShow: false
    };
  },
  methods: {
    backPages() {
      this.$router.go(-1);
    },
    morePages() {
      Toast({
        message: "功能还没做 ^^",
        iconClass: "icon icon-success"
      });
    },
    switchPages(i) {
      switch (i) {
        case 1:
          this.$router.push({
            path: "/classify"
          });
          break;
        case 2:
          this.$router.push({
            path: "/find"
          });
          break;
        case 3:
          this.$router.push({
            path: "/user"
          });
          break;
        default:
          this.$router.push({
            path: "/"
          });
      }
    }
  },
  mounted() {
    //当前选中
    this.selected = this.$router.history.current.name;
    //全局路由守卫
    this.$router.afterEach((to, from) => {
      // 页面标题
      if (typeof to.name !== "undefined") {
        this.pageTitle = to.name;
      }
      console.log(to.name)
      // 返回键显示
      if (
        to.fullPath == "/" ||
        to.fullPath == "/classify" ||
        to.fullPath == "/find" ||
        to.fullPath == "/user"
      ) {
        this.isBackShow = false;
      } else {
        this.isBackShow = true;
      }
    });
  }
};
</script>
<style lang="less">

</style>
