<template>
    <div class="index">
        <div class="index-user"></div>
    </div>
</template>
<script>
/*
 * 这是一个基于 Vue 的 webpack 插件，为单页/多页应用生成骨架屏 skeleton，减少白屏时间，在页面完全渲染之前提升用户感知体验。
 * 当前文件位置为插件指定，请勿更名、移动或删除。
 */
export default {
  name: "skeleton"
};
</script>
<style lang="less" scoped>
.index {
  width: 100%;
  height: 100%;
  background-color: @bgGray;
  /* 用户信息 */
  .index-user {
    width: 100%;
    height: 208px/@p;
    color: @white;
    padding: 0 50px/@p;
    background: -moz-linear-gradient(
      right top,
      left bottom,
      @indexLeftBottom 0%,
      @indexRightTop 100%
    );
    background: -webkit-gradient(
      linear,
      right top,
      color-stop(0%, @indexLeftBottom),
      color-stop(100%, @indexRightTop)
    );
    background: -webkit-linear-gradient(
      right top,
      @indexLeftBottom 0%,
      @indexRightTop 100%
    );
    background: -o-linear-gradient(
      right top,
      @indexLeftBottom 0%,
      @indexRightTop 100%
    );
    background: -ms-linear-gradient(
      right top,
      @indexLeftBottom 0%,
      @indexRightTop 100%
    );
    background: linear-gradient(
      to right top,
      @indexLeftBottom 0%,
      @indexRightTop 100%
    );
  }
}
</style>
