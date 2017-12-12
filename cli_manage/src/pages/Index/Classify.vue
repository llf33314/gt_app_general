<template>
  <div class="classify">
    <!--我的行业-->
    <div class="classify-trade">
      <div class="classify-trade-title">行业分类（仅供内测）</div>
      <div class="classify-trade-content">
        <!-- 汽车 -->
        <span class="classify-trade-col carModule" @click="jumpPages('car')">
          <span class="col-content">
            <div class="icon-bg">
              <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-car"></use>
              </svg>
            </div>
            <div class="text">汽车</div>
          </span>
        </span>
        <!-- 物业 -->
        <span class="classify-trade-col homeModule" @click="jumpPages('home')">
          <span class="col-content">
            <div class="icon-bg">
              <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-wuye"></use>
              </svg>
            </div>
            <div class="text">物业</div>
          </span>
        </span>
        <!-- 商城 -->
        <span class="classify-trade-col shopModule" @click="jumpPages()">
          <span class="col-content">
            <div class="icon-bg">
              <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-shop"></use>
              </svg>
            </div>
            <div class="text">商城</div>
          </span>
        </span>
      </div>
    </div>
  </div>
</template>
<script>
import computed from "./../../assets/js/computed.js";

export default {
  data() {
    return {};
  },
  methods: {
    jumpPages(module) {
      if (module === "car") {
        if (window.toast != "") {
          window.toast.close();
        }
        window.toast = this.$toast({
          message: "暂未开放",
          position: "middle",
          duration: 5000
        });
      } else if (module === "home") {
        window.location.href = window.homeUrl;
      } else {
        if (window.toast != "") {
          window.toast.close();
        }
        window.toast = this.$toast({
          message: "暂未开放",
          position: "middle",
          duration: 5000
        });
      }
    }
  },
  store: this.$store,
  computed,
  mounted() {}
};
</script>
<style lang="less" scoped>
.classify {
  width: 100%;
  /* 我的行业 */
  .classify-trade {
    width: 100%;
    background-color: @bgColor;
    text-align: center;
    .classify-trade-title {
      width: 100%;
      padding: 11px 20px;
      font-size: 45px/@p;
      border-bottom: 1px solid @brColor;
    }
    .classify-trade-content {
      width: 100%;
      .classify-trade-col {
        width: 32%;
        height: 100px;
        .col-content {
          height: inherit;
          display: flex;
          flex-direction: column;
          align-items: center;
          justify-content: center;
          .icon-bg {
            width: 50px;
            height: 50px;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            border-radius: 5px;
            margin: 7px 0;
            color: #fff;
            .icon {
              font-size: 30px;
            }
          }
          .text {
            font-size: 40px/@p;
          }
        }
      }
    }
  }
}
</style>
