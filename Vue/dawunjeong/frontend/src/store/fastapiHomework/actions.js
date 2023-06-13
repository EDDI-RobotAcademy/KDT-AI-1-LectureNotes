import axiosInst from '@/utility/axiosInst'

export default {
    getSecondNumber () {
        return axiosInst.get('/getNumber/second')
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}