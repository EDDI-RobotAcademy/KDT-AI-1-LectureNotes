import axiosInst from "@/utility/axiosInst";

export default {
    requestGetHi() {
        return axiosInst.get('/basic/get-hi')
            .then((res)=> alert(res.data))
            .catch(()=>alert("전송실패"))
    },
    requestDiceNumber() {
        return axiosInst.get('/basic/get-dice')
            .then(((res)=>res.data))
            .catch(()=>alert("전송실패"))
    }
}