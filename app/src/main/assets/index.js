function setJSData(data){
  return JSON.parse(JSON.stringify(data))
}

/*
const json = {
  date: '2024.03.13',
  mercury: 9, // 水
  venus: 22, // 金
  mars: 21, // 火
  jupiter: 2, // 木
  saturn: 23, // 土
}
*/


const layerRadii = [40, 120, 200, 280, 360]; // 假设每层的内半径

function placePoint(pointElement, layerIndex, angle, layers) {
  const diskRadius = document.getElementById('disk-container').offsetWidth / 2;
  const pointSize = 10; // 点的大小
  const radius = layerRadii[layerIndex - 1]; // 获取当前层的内半径

  // 计算圆上点的位置
  const radians = (angle * Math.PI / 36) - (Math.PI / 2);
  const x = diskRadius + (radius - pointSize / 2) * Math.cos(radians);
  const y = diskRadius + (radius - pointSize / 2) * Math.sin(radians);

  // 设置点的位置并显示
  pointElement.style.left = `${x}px`;
  pointElement.style.top = `${y}px`;
  pointElement.style.display = 'block';

  // 将点放在正确的层上
  const diskContainer = document.getElementById('disk-container');
  diskContainer.appendChild(pointElement);

  // 确保点在当前层的上方
  pointElement.style.zIndex = layers.length - layerIndex;
}

// 假设有layers个层，从1到layers，1为最外层
const layers = document.querySelectorAll('.disk-layer');
layers.forEach((layer, index) => {
  layer.style.width = `${layerRadii[index] * 2}px`;
  layer.style.height = `${layerRadii[index] * 2}px`;
  layer.style.transform = `translate(-50%, -50%)`;
});

// 给定五个点的坐标，比如a的坐标是20，且在第一层
placePoint(document.getElementById('pointA'), 1, setJSData.mercury, layers);
placePoint(document.getElementById('pointB'), 2, setJSData.venus, layers);
placePoint(document.getElementById('pointC'), 3, setJSData.mars, layers);
placePoint(document.getElementById('pointD'), 4, setJSData.jupiter, layers);
placePoint(document.getElementById('pointE'), 5, setJSData.saturn, layers);

window.document.title = setJSData.date
