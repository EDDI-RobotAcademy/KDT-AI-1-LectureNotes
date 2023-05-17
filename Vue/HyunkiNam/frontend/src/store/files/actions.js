import axiosInst from '@/utility/axiosInst'

export default {
    requestRegisterFileInfoToSpring({ }, payload) {

        return axiosInst.post('/file/uploadImgsWithText', payload)
            .then((res) => {
                alert('ㄱㄱ')
                return res.data
            })
            .catch((res) => {
                alert('ㄴㄴ')
            })
    },

    requestImageListToSpring({ }) {
        return axiosInst.get('/file /giveMeImageList')
            .then((res) => {
                alert('이미지 리스트 요청: ' + JSON.stringify(res.data))
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    }
}