<template>
  <div class="index-info homeModule">
    <div class="index-info-title">
        <span class="icon-bg">
            <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-wuye"></use>
            </svg>
        </span>
        <span>揽胜家园</span>
    </div>
    <div class="index-info-content">
      <mt-spinner color="#ff4257" class="loading" v-if="loading"></mt-spinner>
      <div class="content-row" v-if="!loading">
        <div class="content-col">
            <div class="col-number">{{data.monthReceivable}}</div>
            <div class="col-text">本月应收</div>
        </div>
        <div class="content-col">
            <div class="col-number">{{data.monthReceipts }}</div>
            <div class="col-text">本月实收</div>
        </div>
        <div class="content-col">
            <div class="col-number">{{data.monthNewCheck}}</div>
            <div class="col-text">本月新入住</div>
        </div>
      </div>
    </div>
</div>
</template>
<script>
import { index } from "@/assets/js/api.js";
export default {
  data() {
    return {
      data: {},
      loading: true
    };
  },
  mounted() {
    const vm = this;
    //根据行业code获取各行业信息
    index.getIndustryInfo({
      params: 5,
      fn: data => {
        vm.data = data
        vm.loading = false
      }
    });
  }
};
</script>