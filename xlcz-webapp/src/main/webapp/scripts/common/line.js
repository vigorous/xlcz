var chart1 = echarts.init(document.getElementById('chart1'));
var option = {
	color: ['#ff9d02'],
	tooltip: {
		trigger: 'axis',
		axisPointer: { // 坐标轴指示器，坐标轴触发有效
			type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
		}
	},
	legend: {
		data: ['累计出口额']
	},
	xAxis: [{
		type: 'category',
		data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月'],
		axisTick: {
			alignWithLabel: true
		},
		splitLine: {
			show: true
		},
	}],
	yAxis: [{
		type: 'value',
		splitLine: {
			show: true
		},
	}],
	series: [{
		name: '累计出口额',
		type: 'line',
		data: [0,0,0,0,0,0,1000,1180,0,0]
	}]
};

chart1.setOption(option, true)