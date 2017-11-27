<template>
    <div class="classify">
        <img :src="banner" width="100%">
        <img :src="banner" width="100%">
        <img :src="banner" width="100%">
        <img :src="banner" width="100%">
        <img :src="banner" width="100%">
        <img :src="banner" width="100%">
        <img :src="banner" width="100%">
        <df-support />
    </div>
</template>

<script>
import { common } from "@/assets/js/api.js";
export default {
  name: "classify",
  title: "分类",
  data() {
    return {
      banner: ""
    };
  },
  methods: {},
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
.classify {
  width: 100%;
}
</style>

