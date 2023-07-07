import React from 'react'
import { Box, Button, Container, TextField } from '@mui/material'
import { useNavigate } from 'react-router-dom'
import { useMutation, useQueryClient } from 'react-query'
import { registerBoard } from '../api/BoardApi'

const TypeScriptBoardRegisterPage = () => {
  const navigate = useNavigate()
  const queryClient = useQueryClient()
  const mutation = useMutation(registerBoard, {
    onSuccess: (data) => {
      queryClient.setQueryData('board', data)
      navigate(`/react-query-zustand-mui-typescript-board-app/read/${data.boardId}`)
    }
  })

  // event:~  사실상 emit
  const handleSubmit = async (event: React.FormEvent) => {
    event.preventDefault()

    const target = event.target as typeof event.target & {
      elements: {
        title: { value: string }
        writer: { value: string }
        content: { value: string }
      }
    }

    const { title, writer, content } = target.elements

    const data = {
      title: title.value,
      writer: writer.value,
      content: content.value
    }

    await mutation.mutateAsync(data)
  }

  return (
    <Container maxWidth="md" sx={{ marginTop: '2em' }}>
      <form onSubmit={handleSubmit}>
        <Box display="flex" flexDirection="column" gap={2} p={2}>
          <TextField label="제목" name="title" sx={{ borderRadius: '4px' }}/>
          <TextField label="작성자" name="writer" sx={{ borderRadius: '4px' }}/>
          <TextField label="내용" name="content" multiline minRows={10} maxRows={10} sx={{ borderRadius: '4px' }}/>
        </Box>
        <Button type="submit">작성 완료</Button>
      </form>
    </Container>
  )
}

export default TypeScriptBoardRegisterPage