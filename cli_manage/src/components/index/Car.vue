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
      <div class="content-row" v-if="!loading">
        <div class="content-col">
          <div class="col-number">{{data.todayAppointment}}</div>
          <div class="col-text">今日预约</div>
        </div>
        <div class="content-col">
          <div class="col-number">{{data.todayRemind}}</div>
          <div class="col-text">今日提醒</div>
        </div>
        <div class="content-col">
          <div class="col-number">{{data.todayRevenue.toFixed(3)}}</div>
          <div class="col-text">今日营收</div>
        </div>
      </div>
      <div class="content-row" v-if="!loading">
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
  </div>
</template>
<script>
import { index } from "./../../assets/js/api.js";
import computed from "./../../assets/js/computed.js";
export default {
  data() {
    return {
      data: {},
      loading: true
    };
  },
  methods: {
    jumpPages() {
      let count = parseInt(this.clickCount);
      if (isNaN(count)) {
        count = 0;
      }
      count++;
      this.$store.commit("clickCount", count);
      let msg = "现在还没地方跳转啊，不过你既然点了，还是要给点反应 0.0";
      if (parseInt(this.clickCount) >= 5 && parseInt(this.clickCount) < 20) {
        msg = "不要再点我啦 - -#";
      } else if (parseInt(this.clickCount) >= 20 && parseInt(this.clickCount) < 22) {
        msg = "好吧，你点吧，我帮你计数";
      } else if (parseInt(this.clickCount) > 21 && parseInt(this.clickCount) <= 999) {
        msg = "你已经点了我 " + this.clickCount + " 下";
      } else if (parseInt(this.clickCount) > 999 && parseInt(this.clickCount) <= 9999) {
        msg = "厉害了！我的哥！你点 " + this.clickCount + " 下！";
      } else if (parseInt(this.clickCount) > 9999) {
        msg = "逆天了！你突破 " + this.clickCount + " 下！我喝口水，接着数。";
      }
      if (window.tmp !== "") {
        window.tmp.close();
      }
      window.tmp = this.$toast({
        message: msg,
        position: "middle",
        duration: 5000
      });
    }
  },
  store: this.$store,
  computed,
  mounted() {
    const vm = this;
    //根据行业code获取各行业信息
    index.getIndustryInfo({
      params: 2,
      fn: data => {
        vm.data = data;
        vm.loading = false;
      }
    });
  }
};
</script>