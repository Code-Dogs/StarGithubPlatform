//app.js
import axios from './utils/axios'
App({
  onLaunch: function () {
    Promise.prototype.finally = function(callback){
      let P = this.constructor;
      return this.then(
              value => {
                   P.resolve(callback()).then(() => value)
               },
               reason => {
                   P.resolve(callback()).then(() => { throw reason })
               }
           )
    }
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        console.log(res)
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        wx.showLoading({
          title: '登录中',
        })
        axios("POST",'/auth/jwt/loginByCode',res.code).then(res => {
          wx.showToast({
            title: '登录成功',
            icon: 'success',
            duration: 1500
          })
        }).catch(errMsg => {
          wx.showToast({
            title: '登录失败',
            icon: 'none',
            duration: 1500
          })
        }).finally(() =>{
          //wx.hideLoading()
        })
      }
    })
  },
  globalData: {
    platformHost : 'https://gitstar.orzjj.com/api'
  }
})