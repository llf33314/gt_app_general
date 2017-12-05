<template>
    <div class="index">
        <!--用户信息-->
        <div class="index-user">
          <div class="index-user-row">
            <span class="flex-1 text-xs">{{userInfo.name}}</span>
            <span class="flex-1 text-right text-xs">剩余 <b class="text-md">{{userInfo.expireDay}}</b> 天</span>            
          </div>
          <div class="index-user-row">
            <span class="flex-1">
              <span class="index-user-iden">
                <svg class="icon" aria-hidden="true">
                  <use v-if="userInfo.versionCode == 4" xlink:href="#icon-zhizunban"></use>
                  <use v-else xlink:href="#icon-zhizunban"></use>
                </svg>
                <span class="text text-xs">{{userInfo.version}}</span>
              </span>
            </span>
            <span class="flex-1 text-right text-xs">{{new Date(userInfo.expireDate).toLocaleString()}}</span>            
          </div>
        </div>
        <!--账户信息-->
        <div class="index-total">
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
        <!--车小算-->
        <div class="index-info carModule">
          <div class="index-info-title">
            <span class="icon-bg">
              <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-car"></use>
              </svg>
            </span>
            <span>车小算</span>
          </div>
          <div class="index-info-content">
            <div class="content-row">
              <div class="content-col">
                <div class="col-number">1</div>
                <div class="col-text">今日预约</div>
              </div>
              <div class="content-col">
                <div class="col-number">12345</div>
                <div class="col-text">7日内已开订单</div>
              </div>
              <div class="content-col">
                <div class="col-number">1</div>
                <div class="col-text">今日提醒</div>
              </div>
            </div>
            <div class="content-row">
              <div class="content-col">
                <div class="col-number">112</div>
                <div class="col-text">今日营收</div>
              </div>
              <div class="content-col">
                <div class="col-number">15</div>
                <div class="col-text">新增会员</div>
              </div>
              <div class="content-col">
                <div class="col-number">15</div>
                <div class="col-text">新增车主</div>
              </div>
            </div>
          </div>
        </div>
        <!--揽胜家园-->
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
            <div class="content-row">
              <div class="content-col">
                <div class="col-number">100.1</div>
                <div class="col-text">本月应收</div>
              </div>
              <div class="content-col">
                <div class="col-number">1212.00</div>
                <div class="col-text">本月实收</div>
              </div>
              <div class="content-col">
                <div class="col-number">9</div>
                <div class="col-text">本月新入住</div>
              </div>
            </div>
          </div>
        </div>
        <!--商城-->
        <div class="index-info shopModule">
          <div class="index-info-title">
            <span class="icon-bg">
              <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-shop"></use>
              </svg>
            </span>
            <span>商城</span>
          </div>
          <div class="index-info-content">
            <div class="content-row">
              <div class="content-col">
                <div class="col-number">110</div>
                <div class="col-text">今日订单数</div>
              </div>
              <div class="content-col">
                <div class="col-number">12345</div>
                <div class="col-text">待发货</div>
              </div>
              <div class="content-col">
                <div class="col-number">3</div>
                <div class="col-text">维权订单</div>
              </div>
            </div>
            <div class="content-row">
              <div class="content-col">
                <div class="col-number">22</div>
                <div class="col-text">昨日营业额</div>
              </div>
              <div class="content-col">
                <div class="col-number">123</div>
                <div class="col-text">7天营业额</div>
              </div>
              <div class="content-col">
                <div class="col-number">1</div>
                <div class="col-text">结算金额</div>
              </div>
            </div>
          </div>
        </div>
        <!--我的行业-->
        <div class="index-trade">
          <div class="index-trade-title">我的行业</div>
          <div class="index-trade-row">
            <span class="index-trade-col carModule">
              <span class="col-content">
                <div class="icon-bg">
                  <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-car"></use>
                  </svg>
                </div>
                <div class="text">汽车</div>
              </span>
            </span>
            <span class="index-trade-col homeModule">
              <span class="col-content">
                <div class="icon-bg">
                  <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-wuye"></use>
                  </svg>
                </div>
                <div class="text">物业</div>
              </span>
            </span>
            <span class="index-trade-col shopModule">
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
import { index } from "@/assets/js/api.js";
import store from "@/assets/js/store.js";
import { mapState, mapMutations, mapGetters } from "vuex";

export default {
  data() {
    return {
      userInfo: ""
    };
  },
  methods: {
    jumpPages() {
      this.$router.push({
        path: "/indexPage"
      });
    }
  },
  computed: mapState({
    userId: function(state) {
      let localData = window.localStorage.getItem("userId");
      if (state.user_id === 0 && localData) {
        this.$store.commit("userId", localData);
      }
      return state.userId;
    }
  }),
  mounted() {
    const vm = this;
    index.getAccountInfo({
      params: {},
      fn: data => {
        vm.userInfo = data;
      }
    });
  },
  store
};
</script>
<style lang="less" scoped>
.index {
  width: 100%;
  /* 用户信息 */
  .index-user {
    width: 100%;
    height: 208px/@p;
    color: @white;
    padding: 0 20px;
    background: -moz-linear-gradient(
      right top,
      left bottom,
      #ff8261 0%,
      #ff4257 100%
    );
    background: -webkit-gradient(
      linear,
      right top,
      color-stop(0%, #ff8261),
      color-stop(100%, #ff4257)
    );
    background: -webkit-linear-gradient(right top, #ff8261 0%, #ff4257 100%);
    background: -o-linear-gradient(right top, #ff8261 0%, #ff4257 100%);
    background: -ms-linear-gradient(right top, #ff8261 0%, #ff4257 100%);
    background: linear-gradient(to right top, #ff8261 0%, #ff4257 100%);
    .index-user-row {
      display: flex;
      padding: 7px 0;
      align-items: center;
      .index-user-iden {
        height: 66px/@p;
        border-radius: 66px/@p;
        padding: 0 10px 0 2px;
        background-color: #ff9d90;
        .icon {
          font-size: 20px;
          padding-top: 1px;
          vertical-align: middle;
        }
        .text {
          line-height: 66px/@p;
          word-wrap: normal;
          text-overflow: ellipsis;
          overflow: hidden;
          vertical-align: middle;
        }
      }
      .text-md {
        font-weight: 549;
      }
    }
  }
  /* 账户信息 */
  .index-total {
    width: 100%;
    border-bottom: 10px solid @brGray;
    display: flex;
    .flex-1 {
      text-align: center;
      .index-total-number {
        color: @red;
        font-size: 60px/@p;
        padding-top: 15px;
      }
      .index-total-text {
        padding-top: 15px;
        padding-bottom: 20px;
        color: @gray;
        font-size: 40px/@p;
      }
    }
  }
  /* 模块信息 */
  .index-info {
    width: 100%;
    border-bottom: 10px solid @brGray;
    .index-info-title {
      height: 121px/@p;
      font-size: 45px/@p;
      font-weight: 545;
      border-bottom: 1px solid @brGray;
      display: flex;
      align-items: center;
      justify-content: center;
      .icon-bg {
        color: #fff;
        width: 22px;
        height: 22px;
        border-radius: 100%;
        margin-right: 10px;
        display: flex;
        align-items: center;
        justify-content: center;
        .icon {
          font-size: 16px;
        }
      }
    }
    .index-info-content {
      width: 100%;
      padding: 20px 0;
      .content-row {
        width: 100%;
        display: flex;
        padding-bottom: 20px;
        .content-col {
          display: flex;
          flex-direction: column;
          align-items: center;
          justify-content: center;
          flex: 1;
          .col-number {
            font-size: 60px/@p;
          }
          .col-text {
            color: @gray;
            padding-top: 15px;
            font-size: 40px/@p;
          }
        }
        &:last-child {
          padding-bottom: 0;
        }
      }
    }
  }
  /* 我的行业 */
  .index-trade {
    .index-trade-title {
      width: 100%;
      padding: 11px 20px;
      font-size: 45px/@p;
      border-bottom: 1px solid @brGray;
    }
    .index-trade-row {
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
  /* 车小算模块 */
  .carModule {
    .icon-bg {
      background: -moz-linear-gradient(
        left,
        right,
        @carIconLeft 0%,
        @carIconRight 100%
      );
      background: -webkit-gradient(
        linear,
        right,
        color-stop(0%, #23c0f6),
        color-stop(100%, #229beb)
      );
      background: -webkit-linear-gradient(
        right,
        @carIconLeft 0%,
        @carIconRight 100%
      );
      background: -o-linear-gradient(
        right,
        @carIconLeft 0%,
        @carIconRight 100%
      );
      background: -ms-linear-gradient(
        right,
        @carIconLeft 0%,
        @carIconRight 100%
      );
      background: linear-gradient(
        to right,
        @carIconLeft 0%,
        @carIconRight 100%
      );
    }
    .col-number {
      color: @carColor;
    }
  }
  /* 揽胜家园模块 */
  .homeModule {
    .icon-bg {
      background: -moz-linear-gradient(
        left,
        right,
        @homeIconLeft 0%,
        @homeIconRight 100%
      );
      background: -webkit-gradient(
        linear,
        right,
        color-stop(0%, @homeIconLeft),
        color-stop(100%, @homeIconRight)
      );
      background: -webkit-linear-gradient(
        right,
        @homeIconLeft 0%,
        @homeIconRight 100%
      );
      background: -o-linear-gradient(
        right,
        @homeIconLeft 0%,
        @homeIconRight 100%
      );
      background: -ms-linear-gradient(
        right,
        @homeIconLeft 0%,
        @homeIconRight 100%
      );
      background: linear-gradient(
        to right,
        @homeIconLeft 0%,
        @homeIconRight 100%
      );
    }
    .col-number {
      color: @homeColor;
    }
  }
  /* 商城模块 */
  .shopModule {
    .icon-bg {
      background: -moz-linear-gradient(
        left,
        right,
        @shopIconLeft 0%,
        @shopIconRight 100%
      );
      background: -webkit-gradient(
        linear,
        right,
        color-stop(0%, @shopIconLeft),
        color-stop(100%, @shopIconRight)
      );
      background: -webkit-linear-gradient(
        right,
        @shopIconLeft 0%,
        @shopIconRight 100%
      );
      background: -o-linear-gradient(
        right,
        @shopIconLeft 0%,
        @shopIconRight 100%
      );
      background: -ms-linear-gradient(
        right,
        @shopIconLeft 0%,
        @shopIconRight 100%
      );
      background: linear-gradient(
        to right,
        @shopIconLeft 0%,
        @shopIconRight 100%
      );
      .icon {
        font-size: 13px;
      }
    }
    .col-number {
      color: @shopColor;
    }
  }
}
</style>
