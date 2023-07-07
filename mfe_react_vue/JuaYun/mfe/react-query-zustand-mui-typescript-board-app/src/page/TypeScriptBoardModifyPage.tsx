import { Box, Button, Container, TextField } from '@mui/material'
import React, { useState } from 'react'
import { useQueryClient } from 'react-query'
import { useNavigate, useParams } from 'react-router-dom'
import { useBoardQuery, useBoardUpdateMutation } from '../api/BoardApi'

interface RouteParams {
  boardId: string
  [key: string]: string
}

const TypeScriptBoardModifyPage = () => {
  const navigate = useNavigate()
  const { boardId } = useParams<RouteParams>()
  const queryClient = useQueryClient()

  const { data: board, isLoading, isError } = useBoardQuery(boardId || '')
  const mutation = useBoardUpdateMutation()

  // board의 변경 사항을 직접 지정하여 불러온것  
  const [title, setTitle] = useState(board?.title || '')
  const [content, setContent] = useState(board?.content || '')

  const handleEditFinishClick = async () => {
    // back 수정코드에서 작성한 내용을 가져와야함 거기에 writer도 존재했음
    const { writer } = board || {}

    if (title && content && writer) {
      const updatedData = {
        boardId, title, content, writer
      }

      await mutation.mutateAsync(updatedData)

      queryClient.invalidateQueries(['board', boardId])
      navigate(`/react-query-zustand-mui-typescript-board-app/read/${boardId}`)

    }
  }

  const handleCancelClick = () => {
    queryClient.invalidateQueries('boardList')
    navigate(`/react-query-zustand-mui-typescript-board-app/read/${boardId}`)
  }

  return (
    <Container maxWidth="md" sx={{ marginTop: '2rem' }}>
      <Box display="flex" flexDirection="column" gap={2} p={2}>
        <TextField label="제목" name="title"
                    value={ title } sx={{ borderRadius: '4px' }}
                    onChange={ (e) => setTitle(e.target.value) }/>
        <TextField label="작성자" name="writer" disabled 
                    value={ board?.writer || '' } sx={{ borderRadius: '4px' }}/>
        <TextField label="작성일자" name="createdDate" disabled 
                    value={ board?.createdDate || '' } sx={{ borderRadius: '4px' }}/>
        <TextField label="내용" name="content" multiline
                    value={ content } minRows={10} maxRows={10} sx={{ borderRadius: '4px' }}
                    onChange={ (e) => setContent(e.target.value) }/>
        <Button variant='outlined' onClick={ handleEditFinishClick }>수정 완료</Button>
        <Button variant='outlined' onClick={ handleCancelClick }>취소</Button>
      </Box>
    </Container>
  )
}

export default TypeScriptBoardModifyPage