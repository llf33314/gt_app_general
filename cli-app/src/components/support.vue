<template>
    <div :class="bottom">
        <img src="../../static/img/support.png" alt="多粉技术支持" width="30%">
    </div>
</template>

<script>
export default {
  data() {
    return {
      bottom: "support"
    };
  },
  mounted() {
    const vm = this;
    setTimeout(function() {
      const contentHetght = document.querySelector(".router-content")
        .offsetHeight + 100;
      if (window.screen.height > contentHetght) {
        vm.bottom = "support-bottom";
      }
    }, 100);
  }
};
</script>

<style lang="less" scoped>
.support {
  width: 100%;
  text-align: center;
  padding: 10px 0;
}
.support-bottom {
  width: 100%;
  position: fixed;
  bottom: 60px;
  text-align: center;
}
</style>