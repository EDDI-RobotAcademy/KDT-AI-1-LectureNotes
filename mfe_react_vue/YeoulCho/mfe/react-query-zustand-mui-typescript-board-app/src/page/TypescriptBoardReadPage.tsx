import { Box, Button, Container, TextField } from '@mui/material'
import React ,{ useEffect }from 'react'
import { useQueryClient } from 'react-query'
import { useNavigate, useParams } from 'react-router-dom'
import { fetchBoard, useBoardQuery } from '../api/BoardApi'

interface RouteParams {
    boardId: string
    [key: string]: string
}

const TypescriptBoardReadPage = () => {
    const navigate = useNavigate()
    const { boardId } = useParams<RouteParams>() //가변인자가 여기로 핸들링하기위함
    const queryClient = useQueryClient()

    const {data: board, isLoading, isError} = useBoardQuery(boardId || '')

    useEffect(()=>{
        const fetchBoardData = async () => {
            const data = await fetchBoard(boardId || '')
            console.log(data)
        }

        fetchBoardData()
    })

    const handleEditClick = () => {
        navigate(`/react-query-zustand-mui-typescript-board-app/modify/${boardId}`)
    }
    const handleDeleteClick = () => {
        console.log('삭제')
    }
    const handleCancelClick = () => {
        queryClient.invalidateQueries('boardList') //화면 다시 그리기
        navigate('/react-query-zustand-mui-typescript-board-app')
    }
  return (
    <Container maxWidth="md" sx={{marginTop: '2rem'}}>
        <Box display="flex" flexDirection="column" gap={2} p={2}>
            <TextField label="제목" name="title" disabled
                        value={board?.title||''} sx={{ boarderRadius: '4px'}}/>
            <TextField label="작성자" name="writer" disabled 
                        value={board?.writer || '' } sx={{ boarderRadius: '4px'}}/>
            <TextField label="내용" name="content" multiline 
                        value={ board?.content || '' } disabled minRows={15} 
                        maxRows={15} sx={{ boarderRadius: '4px'}}/>
            <Button variant='outlined' onClick={handleEditClick}> 수정</Button>
            <Button variant='outlined' onClick={handleDeleteClick}> 삭제</Button>
            <Button variant='outlined' onClick={handleCancelClick}> 돌아가기</Button>
        </Box>
    </Container>
  )
}

export default TypescriptBoardReadPage