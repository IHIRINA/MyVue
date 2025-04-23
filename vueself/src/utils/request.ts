import axios from 'axios'

const request = axios.create({
    baseURL: 'http://localhost:9090',
    timeout: 30000     //请求时间，30s
})

//request拦截器
//可以自请求发送前对请求做一些处理
//比如统一一些token，对请求参数统一加密
request.interceptors.request.use(config => {
    config.headers['Content-Tpe'] = 'application/json;charset=utf-8';
    //let user = localStorage.getItem("user") ? JSON.parse(localStorge.getItem("user") : null
    //config.headers['token'] = user ? .token
    return config;
}), (error: any) => {
    console.error('request error:' + error)  //for debug
    return Promise.reject(error)
};

//response拦截器
//可以再接口响应后统一处理结果
request.interceptors.response.use(
    response => {
        let res = response.data;

        //兼容服务端返回字符串数据
        if (typeof res == 'string') {
            res = res ? JSON.parse(res) : res
        }
        return res;
    },
    error => {
        console.error('response error : ' + error)
        return Promise.reject(error)
    }
)


export default request