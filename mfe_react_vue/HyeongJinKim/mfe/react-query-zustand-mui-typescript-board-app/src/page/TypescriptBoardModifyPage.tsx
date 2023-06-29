import React, { useState } from "react";

import { Box, Button, Container, TextField } from "@mui/material";
import { useNavigate, useParams } from "react-router-dom";
import { useQueryClient } from "react-query";
import { useBoardQuery } from "../api/BoardApi";

interface RouteParams {
  boardId: string;
  [key: string]: string;
}

const TypescriptBoardModifyPage = () => {
  const navigate = useNavigate();
  const { boardId } = useParams<RouteParams>();
  const queryClient = useQueryClient();

  const { data: board, isLoading, isError } = useBoardQuery(boardId || "");
  //   const mutation = useBoardUpdateMutation();

  const [title, setTitle] = useState(board?.title || "");
  const [content, setContent] = useState(board?.content || "");

  const handleEditFinishClick = () => {
    // navigate(`/react-query-zustand-mui-typescript-board-app/modify/${boardId}`);
  };

  const handleCancelClick = () => {
    navigate(`/react-query-zustand-mui-typescript-board-app/read/${boardId}`);
  };

  return (
    <Container maxWidth="md" sx={{ marginTop: "2rem" }}>
      <Box display="flex" flexDirection="column" gap={2} p={2}>
        <TextField
          label="제목"
          name="title"
          value={board?.title || ""}
          sx={{ borderRadius: "4px" }}
        />
        <TextField
          label="작성자"
          name="writer"
          disabled
          value={board?.writer || ""}
          sx={{ borderRadius: "4px" }}
        />
        <TextField
          label="작성일자"
          name="createDate"
          disabled
          value={board?.createDate || ""}
          sx={{ borderRadius: "4px" }}
        />
        <TextField
          label="내용"
          name="content"
          multiline
          value={board?.content || ""}
          minRows={20}
          maxRows={20}
          sx={{ borderRadius: "4px" }}
        />
        <Button variant="outlined" onClick={handleEditFinishClick}>
          수정 완료
        </Button>
        <Button variant="outlined" onClick={handleCancelClick}>
          취소
        </Button>
      </Box>
    </Container>
  );
};

export default TypescriptBoardModifyPage;
