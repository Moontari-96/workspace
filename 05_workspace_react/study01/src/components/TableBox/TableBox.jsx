const TableBox = () => {
  return (
    <div className="tableBox">
      <table border="1">
        <tr>
          <th colspan="3">Table 연습</th>
        </tr>
        <tr>
          <th>Seq</th>
          <th>Name</th>
          <th>Price</th>
        </tr>
        <tr>
          <td>1</td>
          <td>Apple</td>
          <td>2000</td>
        </tr>
      </table>
    </div>
  )
}
export default TableBox
