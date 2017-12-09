<template>
    <div class="index">
        <!--用户信息-->
        <div class="index-user">
          <div class="index-user-row" v-if="userInfo.name">
            <span class="flex-1 text-md">{{userInfo.name}}</span>
            <span class="flex-1 text-right text-sx">剩余 <b class="text-md">{{userInfo.expireDay}}</b> 天</span>            
          </div>
          <div class="index-user-row" v-if="userInfo.name">
            <span class="flex-1">
              <span class="index-user-iden">
                <div class="flex-middle">
                  <svg class="icon" aria-hidden="true">
                    <use v-if="userInfo.versionCode == 4" xlink:href="#icon-zhizunban"></use>
                    <use v-else xlink:href="#icon-zhizunban"></use>
                  </svg>
                  <span class="text text-sx">{{userInfo.version}}</span>
                </div>
              </span>
            </span>
            <span class="flex-1 text-right text-sx">{{new Date(userInfo.expireDate).Format("yyyy-MM-dd")}}</span>            
          </div>
        </div>

        <div class="index-content">
          <!--账户信息-->
          <div class="index-total" v-if="userInfo.name">
            <span class="flex-1">
              <div class="index-total-number">{{userInfo.fanbiNum}}</div>
              <div class="index-total-text">粉币</div>
            </span>
            <span class="flex-1">
              <div class="index-total-number">{{userInfo.smsNum}}</div>
              <div class="index-total-text">剩余短信</div>
            </span>
            <span class="flex-1">
              <div class="index-total-number">{{userInfo.flowNum}}</div>
              <div class="index-total-text">流量包</div>
            </span>
          </div>

          <!--行业模块-->
          <div :is="item.component" :text="item.text" :key="item.code" v-for="item in userModule"></div>

          <!--我的行业-->
          <div class="index-trade" v-if="userInfo.name">
            <div class="index-trade-title">我的行业</div>
            <div class="index-trade-content">
              <!-- 汽车 -->
              <span class="index-trade-col carModule" :key="item.text" v-for="item in userModule" v-if="item.component === 'car'" @click="jumpPages">
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
              <span class="index-trade-col homeModule" v-else-if="item.component === 'home'" @click="jumpPages(item.id)">
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
              <span class="index-trade-col shopModule" v-else-if="item.component === 'shop'" @click="jumpPages">
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
    </div>
</template>
<script>
import { index } from "./../../assets/js/api.js";
import computed from "./../../assets/js/computed.js";
import car from "../../components/index/Car";
import home from "../../components/index/Home";
import shop from "../../components/index/Shop";

export default {
  data() {
    return {
      userInfo: {},
      userModule: [],
      userIndustry: {}
    };
  },
  methods: {
    jumpPages(id) {
      console.log(id)

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
      // this.$router.push({
      //   path: "/indexPage"
      // });
    },
    
  },
  store: this.$store,
  computed,
  components: {
    car,
    home,
    shop
  },
  mounted() {
    const vm = this;
    //获取账号信息
    index.getAccountInfo({
      fn: res => {
        vm.userInfo = res[0].data;

        for (let i = 0; i < res[1].data.length; i++) {
          if (typeof vm.industry[res[1].data[i].code] !== "undefined") {
            vm.userModule.push({
              component: vm.industry[res[1].data[i].code],
              text: res[1].data[i].name
            });
          }
        }
      }
    });
  }
};
</script>
<style lang="less" scoped>
.index {
  width: 100%;
  background-color: @bgGray;
  /* 用户信息 */
  .index-user {
    width: 100%;
    height: 208px/@p;
    color: @white;
    padding: 0 50px/@p;
    background: linear-gradient(
      to right,
      @indexLeftBottom 0%,
      @indexRightTop 100%
    );
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    z-index: 11;
    .index-user-row {
      display: flex;
      padding: 5px 0;
      align-items: center;
      .index-user-iden {
        height: 66px/@p;
        border-radius: 66px/@p;
        padding: 0 10px 0 2px;
        background-color: #ff9d90;
        .icon {
          font-size: 20px;
        }
        .text {
          padding-left: 10px/@p;
          line-height: 66px/@p;
          word-wrap: normal;
          text-overflow: ellipsis;
          overflow: hidden;
        }
      }
      .text-md {
        font-weight: 549;
      }
    }
  }
  .index-content {
    position: absolute;
    top: 208px/@p;
    left: 0;
    right: 0;
    /* 账户信息 */
    .index-total {
      width: 100%;
      background-color: @bgColor;
      margin-bottom: 10px;
      display: flex;
      .flex-1 {
        text-align: center;
        .index-total-number {
          color: @red;
          font-size: 60px/@p;
          padding-top: 15px;
          word-wrap: normal;
          text-overflow: ellipsis;
          white-space: nowrap;
          overflow: hidden;
        }
        .index-total-text {
          padding-top: 15px;
          padding-bottom: 20px;
          color: @gray;
          font-size: 40px/@p;
        }
      }
    }
    /* 我的行业 */
    .index-trade {
      width: 100%;
      background-color: @bgColor;
      .index-trade-title {
        width: 100%;
        padding: 11px 20px;
        font-size: 45px/@p;
        border-bottom: 1px solid @brGray;
      }
      .index-trade-content {
        width: 100%;
        .index-trade-col {
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
}
</style>
