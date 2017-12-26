<template>
  <div class="index-info carModule">
    <div class="index-info-title">
      <span class="icon-bg">
        <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-car"></use>
        </svg>
      </span>
      <span>车小算</span>
    </div>
    <div class="index-info-content" @click="jumpPages">
      <mt-spinner color="#ff4257" class="loading" v-if="loading"></mt-spinner>

      <!--数据展示-->
      <div v-if="!loading && !errInfo" @click="jumpPages">
        <div class="content-row" >
          <div class="content-col">
            <div class="col-number">{{data.todayAppointment}}</div>
            <div class="col-text">今日预约</div>
          </div>
          <div class="content-col">
            <div class="col-number">{{data.todayRemind}}</div>
            <div class="col-text">今日提醒</div>
          </div>
          <div class="content-col">
            <div class="col-number">{{data.todayRevenue.toFixed(2)}}</div>
            <div class="col-text">今日营收</div>
          </div>
        </div>
        <div class="content-row">
          <div class="content-col">
            <div class="col-number">{{data.newCarOwner7Day}}</div>
            <div class="col-text">今日新增会员</div>
          </div>
          <div class="content-col">
            <div class="col-number">{{data.newMembers7Day}}</div>
            <div class="col-text">今日新增车主</div>
          </div>
          <div class="content-col">
            <div class="col-number">{{data.openOrder7Day}}</div>
            <div class="col-text">今日已开订单</div>
          </div>
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
    jumpPages() {
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
        params: 2,
        fn: data => {
          vm.data = data;
          vm.loading = false;
        }
      });
    }
  },
  mounted() {
    this.getData();
  }
};
</script>