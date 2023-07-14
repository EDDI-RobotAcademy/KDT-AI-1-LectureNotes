import {
    GITHUB_LOGIN_COMPLETE,
    SAVE_USER_TOKEN,
} from './mutation-types'

import axiosInst from '../../utility/axiosInst'
import axios from 'axios'

const getParam = (payload, name) => {
    let curr_url = payload
    let svalue = new Array()

    curr_url = curr_url.split("&");
    console.log("curr_url: " + curr_url)
    for (let i = 0; i < curr_url.length; i++)
    {
        let temp = curr_url[i].split("=");
        console.log("temp: " + temp[0] + ", " + temp[1])
        console.log("[temp[0]]: " + [temp[0]])
        svalue.push(temp[1])
        console.log("svalue: " + svalue)
    }
    return svalue;
}

export default {
    requestGithubLoginToSpring ({ }) {
        console.log('requestGithubLoginToSpring()')

        return axiosInst.springAxiosInst.get('/authentication/github/login')
            .then((res) => {
                return res.data
            })
            .catch((res) => {
                alert("문제 발생!")
            })
    },
    requestAuthroizeToGithub ({ }, payload) {
        console.log('requestAuthroizeToGithub() - payload: ' + payload)
        return axios.get(payload)
        // const parameterArray = getParam(payload, "client_id")
        // console.log("client_id: " + parameterArray[0] + ", scope: " + parameterArray[1])
        // return axios.get('/api', { client_id: parameterArray[0], scope: parameterArray[1] })
    },
    async getAccessTokenFromSpringRedirection ({ commit }, payload) {
        console.log('getAccessTokenFromSpringRedirection()')
        const { code } = payload

        await axiosInst.springAxiosInst.get(`/authentication/github/oauth-code?code=${code}`)
            .then((res) => {
                //alert("res: " + JSON.stringify(res.data))
                localStorage.setItem("userToken", res.data)
                commit(SAVE_USER_TOKEN, res.data)
                console.log('res.data: ' + res.data)
                //commit(GITHUB_LOGIN_COMPLETE, true)
            })
            .catch((res) => {
                alert('문제 발생!')
            })
    }
}