var option = {
	color:['#ff9d02','#1392e1','#c5e9ff','#e4552e','#b5c334','#47b8ff','#2e5aa3','#bf753f','#e7ae88','#ffd40a','#c4ccd3'],
	tooltip: {
		trigger: 'item',
		formatter: "{a} <br/>{b} : {c} ({d}%)"
	},
	legend: {
		orient: 'vertical',
		left: 'left',
		top:'center',
		data: ['化纤头巾', '塑料发夹', '螺丝钉', '塑料凉鞋', '铁钉', '铁制挂锁', '铁制抽屉轨道锁', '面板灯', '玻璃制珠','钢管','其他']
	},
	series: [{
		name: '出口商品',
		type: 'pie',
		radius: '55%',
		center: ['50%', '60%'],
		data: [{
				value: 335,
				name: '化纤头巾'
			},
			{
				value: 310,
				name: '塑料发夹'
			},
			{
				value: 234,
				name: '螺丝钉'
			},
			{
				value: 135,
				name: '塑料凉鞋'
			},
			{
				value: 548,
				name: '铁钉'
			},
			{
				value: 548,
				name: '铁制挂锁'
			},
			{
				value: 548,
				name: '铁制抽屉轨道锁'
			},
			{
				value: 548,
				name: '面板灯'
			},
			{
				value: 548,
				name: '玻璃制珠'
			},
			{
				value: 548,
				name: '钢管'
			},
			{
				value: 20000,
				name: '其他'
			}
		],
		itemStyle: {
			emphasis: {
				shadowBlur: 10,
				shadowOffsetX: 0,
				shadowColor: 'rgba(0, 0, 0, 0.5)'
			}
		}
	}]
};
var chart1 = echarts.init(document.getElementById('chart1'));
chart1.setOption(option);