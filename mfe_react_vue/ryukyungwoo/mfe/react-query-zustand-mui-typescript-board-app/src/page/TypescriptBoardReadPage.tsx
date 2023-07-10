import { Box, Button, Container, TextField } from '@mui/material'
import React, { useEffect } from 'react'
import { useQueryClient } from 'react-query'
import { useNavigate, useParams } from 'react-router-dom'
import { deleteBoard, fetchBoard, useBoardQuery } from '../api/BoardApi'

interface RouteParams {
    boardId: string
    [key: string]: string
}

const TypescriptBoardReadPage = () => {
    const navigate = useNavigate()
    const { boardId } = useParams<RouteParams>()
    const queryClient = useQueryClient()
    
    const { data: board, isLoading, isError } = useBoardQuery(boardId || '')

    useEffect(() => {
        const fetchBoardData = async () => {
            const data = await fetchBoard(boardId || '')
            console.log(data)
        }

        fetchBoardData()
    })

    const handleEditClick = () => {
        navigate(`/react-query-zustand-mui-typescript-board-app/modify/${boardId}`)
    }
    const handleDeleteClick = async () => {
        await deleteBoard(boardId || '')
        queryClient.invalidateQueries('boardList')
        navigate('/react-query-zustand-mui-typescript-board-app')
      }
    const handleCancelClick = () => {
        queryClient.invalidateQueries('boardList')
        navigate('/react-query-zustand-mui-typescript-board-app')
    }

  return (
    <Container maxWidth="md" sx={{ marginTop: '2rem' }}>
        <Box display="flex" flexDirection="column" gap={2} p={2}>
            <TextField label="제목" name="title" disabled
                        value={board?.title || ''} sx={{ borderRadius: '4px' }}/>
            <TextField label="작성자" name="writer" disabled 
                        value={ board?.content || ''} sx={{ borderRadius: '4px' }}/>
            <TextField label="내용" name="content" multiline
                        value={ board?.content || ''} disabled
                        minRows={20} maxRows={20} sx={{ borderRadius: '4px' }}/>
            <Button variant='outlined' onClick={handleEditClick}>수정</Button>
            <Button variant='outlined' onClick={handleDeleteClick}>삭제</Button>
            <Button variant='outlined' onClick={handleCancelClick}>돌아가기</Button>
        </Box>
    </Container>
  )
}

export default TypescriptBoardReadPage