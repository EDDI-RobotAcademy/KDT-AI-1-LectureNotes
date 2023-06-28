import React from 'react'
import { QueryClient, QueryClientProvider, useQuery } from 'react-query'
import axios from 'axios'

// Query: 데이터베이스에 정보를 요청하는 일
// 정보를 처리하는 과정에서 query를 보내면 이에 따른 정보를 DB로부터 가져옴
const queryClient = new QueryClient()
export const ReactQueryBasicStarter = () => {
    return (
    <QueryClientProvider client={queryClient}>
        <ReactQueryExecutor />
    </QueryClientProvider>
    // 이렇게 감싸주면 vuex actions 역할의 컴포넌트들과 연결한다 보면 됨
    // React Query를 사용하기 위해선 사용하고자 하는 컴포넌트를 
    // QueryClientProvider 컴포넌트로 감싸주고 QueryClient 값을 Props로 넣어줘야 하는 것
    )
}

const ReactQueryExecutor = () => {
    const { isLoading, error, data, isFetching } = useQuery("repoData", () => 
      // useQuery: 비동기 데이터를 가져오는데 사용(서버에서 데이터를 가져옴)
      // -> 이 쿼리에 대한 중복 요청이 생성되지 않도록 함
      // 첫 번째 매개변수로는 쿼리의 식별자인 "repoData"를 전달
      axios.get(
        "https://api.github.com/repos/wlsdbwls/KDT-AI-1-LectureNotes"
      )
      // 두 번째 매개변수로는 비동기 데이터를 가져오는 함수 전달(axios 사용)
        .then((res) => res.data)
        .catch((res) => res.data)
    )

    if (isLoading) return "로딩중 ........."

    // 에러메세지는 이렇게 생성해야 뜸
    if (error) return `에러 발생: ${error.message}`

    return (
    <div>
        <div>
            <h1>{data.name}</h1>
            <h1>{data.description}</h1>
            <h1>{data.full_name}</h1>
        </div>
    </div>
  )
}