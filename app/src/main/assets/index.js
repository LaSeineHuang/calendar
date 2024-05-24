// const json = {
//   date: '2024.03.13',
//   mercury: 9, // 水
//   venus: 22, // 金
//   mars: 21, // 火
//   jupiter: 2, // 木
//   saturn: 23, // 土
// }

window.document.title = json.date

let data = {}

const dataObj = {
  0: '娄', 
  1: '胃',
  2: '昴',
  3: '毕',
  4: '觜',
  5: '参',
  6: '井',
  7: '鬼',
  8: '柳',
  9: '星',
  10: '张',
  11: '翼',
  12: '轸',
  13: '角',
  14: '亢',
  15: '氏',
  16: '房',
  17: '心',
  18: '尾',
  19: '箕',
  20: '斗',
  21: '牛',
  22: '虚',
  23: '危',
  24: '室',
  25: '壁',
  26: '奎',
}

let table = []

const setJSData = (json) => {
  data = JSON.parse(JSON.stringify(json))
  table = [
    { wuyao: '水曜', xiuwei: data.mercury, xiuming: dataObj[data.mercury] },
    { wuyao: '金曜', xiuwei: data.venus, xiuming: dataObj[data.venus] },
    { wuyao: '火曜', xiuwei: data.mars, xiuming: dataObj[data.mars] },
    { wuyao: '木曜', xiuwei: data.jupiter, xiuming: dataObj[data.jupiter] },
    { wuyao: '土曜', xiuwei: data.saturn, xiuming: dataObj[data.saturn] },
  ]
  let html = ''
  for(let i = 0; i < table.length; i++){
    html += `<tr>
    <td class="td1">${table[i].wuyao}</td>
    <td>${table[i].xiuwei}</td>
    <td>${table[i].xiuming}</td>
  </tr>`
  }
  setTimeout(() => {
    document.getElementById('tbody').innerHTML = html
  }, 100)
}

setJSData(json)


const layerRadii = [60, 150, 250, 350, 450]; // 每层的内半径
const starRadius = 60
const placePoint = (xiuwei, circleRadius, elementId) => {
  const angleDegrees = - 360 / 28 * xiuwei;
  const angleRadians = angleDegrees * (Math.PI / 180);

  const x = circleRadius * Math.cos(angleRadians);
  const y = circleRadius * Math.sin(angleRadians);

  const pointElement = document.getElementById(elementId);

  pointElement.style.left = `${circleRadius + x - starRadius}px`;
  pointElement.style.top = `${circleRadius + y - starRadius}px`;
}

const layers = document.querySelectorAll('.disk-layer');
layers.forEach((layer, index) => {
  layer.style.width = `${layerRadii[index] * 2}px`;
  layer.style.height = `${layerRadii[index] * 2}px`;
});


placePoint(data.mercury, layerRadii[0], 'pointA')
placePoint(data.venus, layerRadii[1], 'pointB')
placePoint(data.mars, layerRadii[2], 'pointC')
placePoint(data.jupiter, layerRadii[3], 'pointD')
placePoint(data.saturn, layerRadii[4], 'pointE')

