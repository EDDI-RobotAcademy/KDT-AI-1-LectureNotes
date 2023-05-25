import axiosInst from '@/utility/axiosInst'

export default {
    requestIntegerToFastApiAfterSpring ({ }) {
        return axiosInst.get('/fastapi-test/fastapi-integer-request')       
            .then((res) => {
                // alert('응답데이터: ' + JSON.stringify(res.data))
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}