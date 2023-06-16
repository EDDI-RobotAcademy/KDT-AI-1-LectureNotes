import axiosInstances from '@/utility/axiosInst'

export default {
    requestPredictedResultToFastapi({ }) {
        return axiosInstances.fastApiAxiosInst.get('/keras')
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
    requestTestSalaryToFastapi({ }) {
        return axiosInstances.fastApiAxiosInst.get('/test-salary')
            .then((res) => {
                return res.data
            })
            .catch(() => {
                alert('문제 발생!')
            })
    },
}