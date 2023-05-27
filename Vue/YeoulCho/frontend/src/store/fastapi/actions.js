import axiosInst from '@/utility/axiosInst'

export default {
    requestIntegertoFastApiAfteroSpring ({}, ) { 
        return axiosInst.get('fastapi-test/fastapi-integer-request')
            .then((res) => res
            //.then((res)=>{return res})
            )
            .catch(()=>{
                alert('문제발생!')
            })
    },
    
    
}