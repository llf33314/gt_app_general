<template>
  <div id="app">
    <pull-to :top-load-method="refresh">
      <transition :name="transitionName">
        <router-view class="router-view" />
      </transition>
    </pull-to>
  </div>
</template>
<script>
export default {
  name: "app",
  data() {
    return {
      pageTitle: "",
      isBackShow: false,
      transitionName: "slide-left"
    };
  },
  methods: {
    //下拉刷新
    refresh(loaded) {
      setTimeout(() => {
        this.$router.go(0);
        loaded("done");
      }, 2000);
    }
  },
  //监听路由的路径，可以通过不同的路径去选择不同的切换效果
  watch: {
    $route(to, from) {
      const toDepth = to.path.split("/").length;
      const fromDepth = from.path.split("/").length;
      this.transitionName = toDepth < fromDepth ? "slide-right" : "slide-left";
    }
  }
};
</script>
<style lang="less">
.router-view {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  transition: all 0.5s cubic-bezier(0.55, 0, 0.1, 1);
}
.slide-left-enter,
.slide-right-leave-active {
  opacity: 0;
  -webkit-transform: translate(30px, 0);
  transform: translate(30px, 0);
}
.slide-left-leave-active,
.slide-right-enter {
  opacity: 0;
  -webkit-transform: translate(-30px, 0);
  transform: translate(-30px, 0);
}
.default-text{
  font-size: 22px;
  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>