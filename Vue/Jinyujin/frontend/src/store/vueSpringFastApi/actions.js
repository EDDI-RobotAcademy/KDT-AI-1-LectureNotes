import axiosInstances from '@/utility/axiosInst'

export default {
    requestfirstNumberToSpring({ }) {
        return axiosInstances.axiosInst.get('/vue-spring/first-number')
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestSecondNumberToSpring({ }) {
        return axiosInstances.springAxiosInst.get('/vue-spring/second-number')
            .then((res) => {
                return res.data
                console.log('data: ' + res.data)
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestThirdNumberToFastApi({ }) {
        return axiosInstances.fastApiAxiosInst.get('/request_third_number')
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
                //console.log('제발: ' + res.data)
            })
        
    },
}