import React, { useEffect, useRef } from 'react'

const VuetifyBoardAppListRouter = () => {
    const vuetifyBoardListRef = useRef(null)

    useEffect(() => {
        const loadRemoteComponent = async () => {
            const { listBootstrapMount } = await import('vuetifyTailwindBoardApp/boardListBootstrap')
            listBootstrapMount(vuetifyBoardListRef.current)
        }

        loadRemoteComponent()
    }, [vuetifyBoardListRef])

    return (
        <div>
            <div>
                <div style={{ position: 'relative' }} ref={vuetifyBoardListRef} />
            </div>
        </div>
    )
}

export default VuetifyBoardAppListRouter