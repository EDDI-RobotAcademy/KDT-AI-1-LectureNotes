import {
    REQUEST_TEST_IMAGE_PATH_TO_SPRING,
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestImagePathToSpring({ commit }) {
        return axiosInst.get('/give-me/image-path')
            .then((res) => {
                commit(REQUEST_TEST_IMAGE_PATH_TO_SPRING, res.data)
                // commit을 해서 mutation이 동작하도록!!
                // 지금은 페이지에서 mapState를 쓰지 않기 때문에 commit을 해줄 필요가 없음
                return res.data

                // return을 쓰지 않으려면 commit을 사용해서 mutation이 작동하게 해주어야 함
            })
    },
}