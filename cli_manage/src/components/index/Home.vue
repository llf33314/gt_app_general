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
      <div class="content-row" v-if="!loading && !errInfo" @click="jumpInfo">
        <!--数据展示-->
        <div class="content-col">
            <div class="col-number">{{data.monthReceivable.toFixed(2)}}</div>
            <div class="col-text">本月应收</div>
        </div>
        <div class="content-col">
            <div class="col-number">{{data.monthReceipts.toFixed(2)}}</div>
            <div class="col-text">本月实收</div>
        </div>
        <div class="content-col">
            <div class="col-number">{{data.monthNewCheck}}</div>
            <div class="col-text">本月新入住</div>
        </div>
      </div>
      <!--错误提示-->
      <div class="content-row" v-else-if="errInfo" @click="getData">
        <div class="content-col">
            <div class="col-text">数据获取失败，请点击重试</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { index } from "./../../assets/js/api.js";

export default {
  data() {
    return {
      data: {},
      loading: true,
      errInfo: false
    };
  },
  methods: {
    jumpInfo() {
      if (this.data.infoUrl) {
        window.location.href = this.data.infoUrl;
      }
    },
    getData() {
      const vm = this;
      vm.loading = true;
      vm.errInfo = false;
      //根据行业code获取各行业信息
      index.getIndustryInfo({
        params: 5,
        fn: data => {
          vm.data = data;
          vm.loading = false;
        },
        err: msg => {
          vm.loading = false;
          vm.errInfo = true;
        }
      });
    }
  },
  mounted() {
    this.getData();
  }
};
</script>