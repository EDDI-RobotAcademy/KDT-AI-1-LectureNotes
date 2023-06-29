import { Box, Button, Container, TextField } from '@mui/material'
import React ,{ useEffect, useState }from 'react'
import { useMutation, useQueryClient } from 'react-query'
import { useNavigate, useParams } from 'react-router-dom'
import { fetchBoard, modifyBoard, useBoardQuery } from '../api/BoardApi'

interface RouteParams {
    boardId: string
    [key: string]: string
}

const TypescriptBoardModifyPage = () => {
    const navigate = useNavigate()
    const queryClient = useQueryClient()
    const { boardId } = useParams<RouteParams>() //가변인자가 여기로 핸들링하기위함

    const {data: board, isLoading, isError} = useBoardQuery(boardId || '')

    const [title, setTitle] = useState(board?.title || '')
    const [content, setContent] = useState(board?.content || '')

    const handleEditFinishClick = () => {
        //navigate(`/react-query-zustand-mui-typescript-board-app/modify/${boardId}`)
    }
    
    const handleCancelClick = () => {
        navigate('/react-query-zustand-mui-typescript-board-app/read/${boardId}')
    }
    
    const mutation = useMutation(modifyBoard,{
        onSuccess: (data) =>{
            queryClient.setQueryData('board', data)
            navigate(`/react-query-zustand-mui-typescript-board-app/read/:boardId/${data.boardId}`)
        }
    })

    // const handleEditClick = async (event: React.FormEvent) => {
    //     event.preventDefault()
        
    //     const target = event.target as typeof event.target & {
    //         elements: {
    //             title: {value: string}
    //             writer: {value: string}
    //             content: {value: string}

    //         }
    //     }
    //     const {title, writer, content} = target.elements
    //     const data = {
    //         title: title.value,
    //         writer: writer.value,
    //         content: content.value,
    //         boardId: boardId
    //     }
    //     await mutation.mutateAsync(data) 


  return (
    <Container maxWidth="md" sx={{marginTop: '2rem'}}>
        <Box display="flex" flexDirection="column" gap={2} p={2}>
            <TextField label="제목" name="title" 
                        value={board?.title||''} sx={{ boarderRadius: '4px'}}/>
            <TextField label="작성자" name="writer" disabled 
                        value={board?.writer || '' } sx={{ boarderRadius: '4px'}}/>
            <TextField label="작성일자" name="createDate" disabled 
                        value={board?.createDate || '' } sx={{ boarderRadius: '4px'}}/>
            <TextField label="내용" name="content" multiline 
                        value={ board?.content || '' } minRows={15} 
                        maxRows={15} sx={{ boarderRadius: '4px'}}/>
            <Button variant='outlined' onClick={handleEditFinishClick}> 수정</Button>
            <Button variant='outlined' onClick={handleCancelClick}> 돌아가기</Button>
        </Box>
    </Container>
  )
}

export default TypescriptBoardModifyPage