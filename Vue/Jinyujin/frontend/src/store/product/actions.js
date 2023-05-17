import {
    REQUEST_PRODUCT_LIST_TO_SPRING
} from './mutation-types'

import axiosProductInst from '@/utility/axiosProductInst'

export default {
    requestProductListoSpring ({commit}) {
        return axiosProductInst.get('/product/list')
        .then((res) => {
            commit(REQUEST_PRODUCT_LIST_TO_SPRING, res.data)
        })
    }
}