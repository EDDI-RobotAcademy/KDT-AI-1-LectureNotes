import React from 'react'
import { QueryClient, QueryClientProvider, useQuery } from 'react-query'
import axios from 'axios'

const queryClient = new QueryClient()
export const ReactQueryBasicStarter = () => {
    return (
    <QueryClientProvider client={queryClient}>
        <ReactQueryExecutor />
    </QueryClientProvider>
    // 이렇게 감싸주면 vuex actions 역할의 컴포넌트들과 연결한다 보면 됨
    )
}

const ReactQueryExecutor = () => {
    const { isLoading, error, data, isFetching } = useQuery("repoData", () => 
      axios.get(
        "https://api.github.com/repos/wlsdbwls/KDT-AI-1-LectureNotes"
      )
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