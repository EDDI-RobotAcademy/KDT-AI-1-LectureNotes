import React, { useEffect } from 'react'
import {useNavigate} from "react-router-dom";

const VueModuleAppRouter = ({ vueModuleRef, buttonRef }) => {
  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { mount } = await import('vueModuleApp/Sample')
      mount(vueModuleRef.current)
      console.log(vueModuleRef.current)
    }

    loadRemoteComponent()

    return () => {
      if (vueModuleRef.current) {
        // app.unmount() 메서드를 사용하여 vueModuleRef 해제
        vueModuleRef.current.unmount();
        console.log(vueModuleRef.current)
      }
    };
  }, [vueModuleRef])

  const navigate = useNavigate();
  const handleButtonClick = (event) => {
    // 버튼의 ID 값을 확인
    const buttonId = event.target.id;

    // 원하는 버튼 ID 값에 따라 라우팅 처리
    if (buttonId === 'vueBoard') {
      navigate('/vue-module-app');
    } else if (buttonId === 'reactButton') {
      navigate('/react-board-app');
    }
  };

  useEffect(() => {
    // Home 컴포넌트가 마운트될 때 버튼 클릭 이벤트 리스너 등록
    buttonRef.current.addEventListener('click', handleButtonClick);

    // Home 컴포넌트가 언마운트될 때 버튼 클릭 이벤트 리스너 해제
    return () => {
      buttonRef.current.removeEventListener('click', handleButtonClick);
    };
  }, []);

  return (
    <div>
      <div>
        <div style={{ position: 'relative' }} ref={vueModuleRef}/>
      </div>
    </div>
  )
}

export default VueModuleAppRouter