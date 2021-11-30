# Share Market

[![Build Status](https://img.shields.io/badge/build-completed-success)](https://github.com/tmdgh1592/Android-Master-of-Collection/)
![License](https://img.shields.io/apm/l/vim-mode?color=yellowgreen)
[![Framework](https://img.shields.io/badge/framework-android-green)](https://developer.android.com/)

# 쉐어마켓


![app_icon](https://user-images.githubusercontent.com/56534241/140684675-b2e92e40-3465-42ab-9eb7-0fea5a519781.png)


<br/>

+ [개발 인원] - 1인 개발 / KBSC 2021 4기 환경을 바꾸는 소프트웨어 공모전 출품작

+ [개발 기간] - 2021/08 - 2021/10

+ [개발 동기] - 1. 현대인들의 소비 활동이 증가하면서, 제품 구매 후 얼마 사용하지 않고 쌓이거나 버려지는 물건이 많아짐.<br/>
                  → 사용하지 않는 물건을 나누어, 환경 개선을 추진하는 ESG 커뮤니티 서비스 앱을 구현하고자 함.<br/>
               2. Covid-19 사태로 인해, 사람들이 특정 장소에 모여 환경 개선 활동을 하기엔 제한이 있음.<br/>
                  → 온라인상에서도 다같이 환경을 개선할 수 있는 방법을 모색하고자 함.

               


+ [핵심 아이디어] - 1.사용하지 않는 물건들을 유저간에 나누거나 교환할 수 있는 O2O 플랫폼을 형성한다.<br/>
    → 나눔, 요청, 물물교환이 가능한 게시판 형태의 커뮤니티를 구축한다.<br/>
    → 1:1 채팅/푸시 기능을 구현하여 나눔을 위한 소통을 유도한다.<br/><br/>

2. 실시간 나눔 현황을 확인할 수 있도록 하여, 나눔으로 변화하는 환경 개선을 시각적으로 확인할 수 있다.<br/>
    → 실시간으로 이루어지고 있는 나눔 현황에 대해 확인할 수 있도록 하고, 나눔을 통해 개선되는 환경 상태를 유저가 직접 수치로 확인할 수 있도록 한다.<br/><br/>

3. 나눔을 완료하면 해당 유저에게 ‘*트리 코인’을 지급하여, Covid-19 환경에서도 온라인상에서 실제 나무를 심을 수 있는   ‘나눔 & 나무’ 캠페인을 제공한다.<br/>
    → 서비스 최초가입 또는 나눔, 요청, 물물교환 완료 시 캠페인에서 사용 가능한 ‘트리 코인’ 2개를 지급한다.<br/>
    → 사용자들이 캠페인에 기부한 트리 코인의 가치만큼 ‘생명의숲’ 단체에 후원금을 지불한다.<br/><br/>

4. 기업 규모에서 지정 기부금 단체에 나눔을 한 경우, 쉐어마켓 채팅 기능과 홈택스 어플을 연동하여 ‘*기부금 영수증’ 발급을 도와준다.<br/>
    → 보육원, 고아원, 교회 등 지정 기부금 단체에 해당하는 기관에서 기업에게 필요한 물품을 요청할 수 있다.<br/>
    → 나눔을 받은 기관에서는 기업에게 기부금 영수증을 발급해줄 수 있고, 사회 · 기업적으로 모두 이익을 얻을 수 있다.<br/><br/><br/>

*트리 코인 : 쉐어마켓에서 나눔 활동시 획득할 수 있는 가상 코인으로, 나눔 & 나무 캠페인 참여에 사용할 수 있다.
코인 1개당 100원에 해당하는 가치를 지니고 있다.
*기부금 영수증 : 기업에서 지정 기부금 단체에게 현물 또는 기부를 할 경우, 해당 가치만큼 세금을 감면받을 수 있는 영수증이다.<br/><br/><br/>

+ [공공성 및 기대효과]<br/>
1. 사용하지 않는 물건을 나눔으로써, 버려지거나 방치되는 물건을 줄여 환경오염을 최소화할 수 있다.<br/>
2. 이웃과의 소통이 적은 현대 사회에서 주변 이웃과의 소통 환경을 마련한다.<br/>
3. 기업에서 지정 기부금 단체에 나눔을 하면, 손택스 어플과 연동할 수 있는 채팅 링크를 전달 받아 ‘기부금 영수증 신청’ 을 요구할 수 있고, 기업은 나눈 금액만큼 세금을 절감받을 수 있어 기업 · 기관 양쪽 모두 이점이 된다.<br/>
4. 나눔을 완료하면 지급되는 ‘트리 코인’ 으로 Covid-19로 인해 단체 환경 개선 활동이 제한되는 상황에서도, 유저들이 온라인에 다 같이 모여 실제 나무를 심을 수 있는 (나눔 & 나무)캠페인에 참여할 수 있다.<br/>
5. 쉐어마켓 콘텐츠 중, ‘나눔 & 나무 캠페인’에 지불한 트리 코인의 가치만큼 ‘생명의숲(숲 가꾸기 시민단체)’ 단체에 정기적으로 후원이 이루어진다.<br/>
6. 나눔으로 개선되는 환경 변화를 사용자가 실시간 수치로 확인할 수 있도록 하여, 나눔의 가치를 이해하고 보람을 느낄 수 있어 지속적인 나눔 활동으로 이어질 수 있다.<br/><br/><br/>


+ [기술 스택] - Android, Kotlin, Java, MVVM, LiveData, Firebase Storage/Realtime DB, Glide

+ [기타] - 군 전역 후 바로 준비한 첫 공모전 프로젝트

+ [기획서] - [쉐어마켓-소프트웨어-기획서.pdf](https://github.com/tmdgh1592/ShareMarket/files/7494450/-.-.pdf)

<br/>
<br/>
<br/>

<a href="https://drive.google.com/file/d/1_0BhxzWR6sfCbDHS1jX0JNEjJCg928VO/view?usp=sharing"><img alt="Get it on Google Drive" src="https://piunikaweb.com/wp-content/uploads/2020/10/google-drive-logo-new.png" width="200px"/></a>
ddd
