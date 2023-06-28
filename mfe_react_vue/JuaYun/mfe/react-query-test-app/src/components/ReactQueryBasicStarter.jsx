import React from 'react'

import { QueryClient, QueryClientProvider, useQuery } from 'react-query'
import axios from 'axios'

const queryClient = new QueryClient()
// 비동기 처리
export const ReactQueryBasicStarter = () => {
  return (
    // vuex actions의 역할의 컴포넌트들과 연결한다 보면 됨
    <QueryClientProvider client={queryClient}>
      <ReactQueryExcutor/>
    </QueryClientProvider>
  )
}

const ReactQueryExcutor = () => {
  const { isLoading, error, data, isFetching } = useQuery("repoData", () => 
    axios.get(
      "https://api.github.com/repos/dbswndk/KDT-AI-1-LectureNotes"
    )
    .then((res) => res.data)
  )

  if (isLoading) return "로딩중..."

  if (error) return "에러 발생: " + error.message

  return (
    <div>
      <h1>{ data.name }</h1>
    </div>
  )
}