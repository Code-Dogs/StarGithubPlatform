const platformip = 'https://gitstar.orzjj.com/api'

const axios = function(method = 'GET',url,data){
  return new Promise( (resolve,reject) => {
    wx.request({
      method:method,
      url: platformip + url,
      data:data,
      success (res) {
        if(res.statusCode !== 200){
          reject(new Error(res.errMsg))
          return
        }
        resolve(res)
      },
      fail(errMsg){
        reject(new Error(errMsg))
      }
    })
  })
}

module.exports = axios