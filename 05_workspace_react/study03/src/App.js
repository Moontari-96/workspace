import { useState } from 'react'
import './App.css'
// function App() {
//   // 모든 UI는 상태에서 파생된다.

//   let count = 1
//   function plus() {
//     count++
//     document.getElementById('counter').innerHTML = count
//   }
//   function minus() {
//     count--
//     document.getElementById('counter').innerHTML = count
//   }

//   return (
//     <div className="App">
//       <div id="counter">{count}</div>
//       <hr></hr>
//       <button id="plus" onClick={plus}>
//         +
//       </button>
//       <button id="minus" onClick={minus}>
//         -
//       </button>
//     </div>
//   )
// }

// function App() {
//   // mount - 최초에 Component가 처음으로 그려지는 경우
//   // unmount - Component가 특정 명령에 의해 브라우저에서 아예 제거되는 상황
//   // 새로고침 - unmount 후 mount 기능과 같음.

//   let count2 = 10 // 함수가 다시 호출 될 때 새로 선언됨.
//   // Destructuring 문법 - 구조 분해 할당

//   const [counter, setCounter] = useState(1)
//   // 상태 변수 생성 = 한 번 선언되면 rerendering에 의해서는 다시 선언되지 않음
//   // 상태 값이 변경되는 경우 상태 변수를 포함하는 함수가 재호출되는데 이를 rerendering 이라고 함.
//   // Component가 unmount 될 때는 초기화 됨.

//   const handlePlus = () => {
//     setCounter(counter + 1)
//     count2++
//   }
//   const handleMinus = () => {
//     setCounter(counter - 1)
//     count2--
//   }

//   return (
//     <div className="App">
//       <div>
//         {counter}
//         <br></br>
//         {count2}
//       </div>
//       <hr />
//       <button onClick={handlePlus}>+</button>
//       <button onClick={handleMinus}>-</button>
//     </div>
//   )
// }

// function App() {
//   const [str, setStr] = useState('기본메시지')
//   const handleChange = e => {
//     if (e.key === 'Enter') {
//       setStr(e.target.value)
//     }
//   }

//   //const handlePopup = () => {}
//   return (
//     <div>
//       <h1>{str}</h1>
//       <hr />

//       <div>
//         <input type="text" onChange={handleChange} onKeyPress={handleChange} />
//         <button
//           onClick={() => {
//             alert(str)
//           }}
//         >
//           Popup!
//         </button>
//       </div>
//     </div>
//   )
// }

// 스트링형 배열
// function App() {
//   const [messages, setMessages] = useState([
//     '백:민주야',
//     '민:담배좀',
//     '주:그만펴라',
//   ]) // 문자열 목록 저장
//   const [message, setMessage] = useState('')

//   const handleChange = e => {
//     setMessage(e.target.value)
//   }
//   const handleSave = () => {
//     // Spread 연산자 ...배열, ...객체
//     setMessages(prev => [...prev, message])
//     setMessage('')
//   }
//   return (
//     <div>
//       <ul>
//         {messages.map((message, index) => (
//           <li key={index}>{message}</li>
//         ))}
//       </ul>
//       <hr />
//       <input type="text" onChange={handleChange} value={message} />
//       <button onClick={handleSave}>Save</button>
//     </div>
//   )
// }

function App() {
  const [state, setState] = useState({
    data: [
      { seq: 1, writer: 'Tom', message: 'Hello React' },
      { seq: 2, writer: 'Sara', message: 'React State Practice' },
      { seq: 3, writer: 'James', message: 'Object Array' },
    ],
    newEntry: { seq: '', writer: '', message: '' },
  })

  const handleChange = e => {
    const { name, value } = e.target
    setState(prev => ({
      ...prev,
      newEntry: {
        ...prev.newEntry,
        [name]: value,
      },
    }))
  }

  const handleSave = () => {
    setState(prev => {
      return {
        data: [
          ...prev.data,
          {
            seq: parseInt(prev.newEntry.seq, 10), // seq 값을 숫자로 변환
            writer: prev.newEntry.writer,
            message: prev.newEntry.message,
          },
        ],
        newEntry: { seq: '', writer: '', message: '' }, // 입력 필드를 초기화
      }
    })
  }

  return (
    <div className="container">
      <table className="messages">
        <thead>
          <tr>
            <th>글번호</th>
            <th>작성자</th>
            <th>메세지</th>
          </tr>
        </thead>
        <tbody>
          {state.data.map((data, index) => (
            <tr key={index}>
              <td>{data.seq}</td>
              <td>{data.writer}</td>
              <td>{data.message}</td>
            </tr>
          ))}
          <tr>
            <td colSpan={3}>
              <input
                type="text"
                name="seq"
                placeholder="글번호"
                value={state.newEntry.seq}
                onChange={handleChange}
              />
              <input
                type="text"
                name="writer"
                placeholder="작성자"
                value={state.newEntry.writer}
                onChange={handleChange}
              />
              <input
                type="text"
                name="message"
                placeholder="내용"
                value={state.newEntry.message}
                onChange={handleChange}
              />
              <button onClick={handleSave}>추가</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default App
