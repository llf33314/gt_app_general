<template>
    <div class="index">
        <img :src="banner" width="100%" @click="jumpPages">
        <div class="test">自适应高度</div>
        <df-support />
    </div>
</template>
<script>
import { common } from "@/assets/js/api.js";

export default {
  data() {
    return {
      banner: ""
    };
  },
  methods: {
    jumpPages() {
      this.$router.push({
        path: "/indexPage"
      });
    }
  },
  mounted() {
    const vm = this;
    common.manage({
      params: {},
      fn: data => {
        vm.banner = data;
      }
    });
  }
};
</script>
<style lang="less" scoped>
.test {
  height: 136px/@p;
  border: 1px solid red;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
