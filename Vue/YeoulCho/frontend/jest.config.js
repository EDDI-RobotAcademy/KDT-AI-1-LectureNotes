module.exports = {
  //vue add unit-jest로 jest.config.js가 구성되고 jest 테스트 의존성이 설치됩니다.
  preset: '@vue/cli-plugin-unit-jest',
  //아래 내용 없이도 테스트가 통과되는 경우라면 적을 필요가 없습니다.
  // TransformIgnorePatterns: ["node_modules/(?!axios)"],
  transformIgnorePatterns: ["node_modules/(?!axios)"],
}
