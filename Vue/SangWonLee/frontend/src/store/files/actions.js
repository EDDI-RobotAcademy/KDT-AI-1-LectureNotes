import axiosInst from "@/utility/axiosInst";

export default {
  requestRegisterFileInfoToSpring({ }, payload) {
    return axiosInst
      .post("/file-test/uploadImgsWithText", payload)
      // axios.post로 Promise 값을 반환한다.
      // Promise란, JavaScript에서 비동기 연산의 최종 완료(결과 값)을 나타내는 객체임

      .then(function (response) {
        console.log(response.data);
        alert("파일 저장 요청 성공!");
      })
      .catch((error) => {
        console.log(error);
        alert("문제 발생!");
      });
  },
  requestImageListToSpring({ }) {
    return axiosInst
      .get("/file-test/giveMeImageList")
      // axios.get도 Promise 값을 반환한다.
      // post와 차이점은 post는 서버에 데이터를 보내는거고
      // get은 서버에서 데이터를 받는거고 ㅇㅇ..

      .then((res) => {
        alert("이미지 리스트 요청: " + JSON.stringify(res.data));
        return res.data;
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
};
