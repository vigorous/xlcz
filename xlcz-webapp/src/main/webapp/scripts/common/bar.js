var chart1 = echarts.init(document.getElementById('chart1'));
var option = {
	color: ['#1392E1'],
	tooltip: {
		trigger: 'axis',
		axisPointer: { // 坐标轴指示器，坐标轴触发有效
			type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
		}
	},
	legend: {
		data: ['累计出口额']
	},
	toolbox: {
		itemSize: 15,
		itemGap: 10,
		right: 10,
		feature: {
			dataView: {
				show: true
			},
			magicType: {
				type: ['line', 'bar', ]
			},
			restore: {

			},
			saveAsImage: {
				pixelRatio: 2
			},
		}
	},
	xAxis: [{
		type: 'category',
		data: ['印度', '伊拉克', '伊朗', '马来西亚', '菲律宾', '泰国', '阿联酋', '智利', '西班牙', '沙特阿拉伯', '其他'],
		axisTick: {
			alignWithLabel: true
		},
		splitLine: {
			show: true
		},
		axisLabel: {
			interval: 0,
			rotate: 60, //倾斜度 -90 至 90 默认为0  
		}
	}],
	yAxis: [{
		type: 'value',
		splitLine: {
			show: true
		},
	}],
	series: [{
		name: '累计出口额',
		type: 'bar',
		data: [150000, 140000, 130000, 120000, 110000, 100000, 80000, 70000, 60000, 50000, 1210000]
	}]
};

chart1.setOption(option, true);

var chart2 = echarts.init(document.getElementById('chart2'));
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
	toolbox: {
		itemSize: 15,
		itemGap: 10,
		right: 10,
		feature: {
			dataView: {
				show: true
			},
			magicType: {
				type: ['line', 'bar', ]
			},
			restore: {

			},
			saveAsImage: {
				pixelRatio: 2
			},
		}
	},
	xAxis: [{
		type: 'category',
		data: ['印度', '伊拉克', '伊朗', '马来西亚', '菲律宾', '泰国', '阿联酋', '智利', '西班牙', '沙特阿拉伯', '其他'],
		axisTick: {
			alignWithLabel: true
		},
		splitLine: {
			show: true
		},
		axisLabel: {
			interval: 0,
			rotate: 60, //倾斜度 -90 至 90 默认为0  
		}
	}],
	yAxis: [{
		type: 'value',
		splitLine: {
			show: true
		},
	}],
	series: [{
		name: '累计出口额',
		type: 'bar',
		data: [150000, 140000, 130000, 120000, 110000, 100000, 80000, 70000, 60000, 50000, 1210000]
	}]
};

chart2.setOption(option, true)
