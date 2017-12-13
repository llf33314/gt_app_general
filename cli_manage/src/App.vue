<template>
  <div id="app">
    <transition :name="transitionName">
      <router-view class="router-view" />
    </transition>
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