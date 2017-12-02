<template>
    <div class="support" :style="style">
        <img src="../../static/img/support.png" alt="多粉技术支持" width="35%">
    </div>
</template>

<script>
export default {
  data() {
    return {
      style: ""
    };
  },
  mounted() {
    let p = window.screen.height - document.body.clientHeight - 20;
    this.style = "padding-top:" + p + "px";
  }
};
</script>

<style lang="less" scoped>
.support {
  width: 100%;
  text-align: center;
  padding-bottom: 20px;
}
</style>