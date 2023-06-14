import {
    REQUEST_PRODUCT_LIST_TO_SPRING
} from './mutation-types'

import axiosInst from '@/utility/axiosInst'

export default {
    requestProductListoSpring ({commit}) {
        return axiosInst.get('/product/list')
        .then((res) => {
            commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data)
        })
    }
}