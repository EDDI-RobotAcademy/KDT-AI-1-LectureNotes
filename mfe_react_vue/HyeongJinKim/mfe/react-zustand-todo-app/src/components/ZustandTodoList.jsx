import React from "react";
import ZustandTodoItem from "./ZustandTodoItem";
import { useTodoStore } from "../zustand/store";

const ZustandTodoList = () => {
  const todos = useTodoStore((state) => state.todos);
  return (
    <ul>
      {todos.map((todo) => (
        <ZustandTodoItem key={todo.id} props={todo} />
      ))}
    </ul>
  );
};

export default ZustandTodoList;
