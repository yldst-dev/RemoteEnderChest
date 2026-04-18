# RemoteEnderChest

RemoteEnderChest는 Paper 서버에서 `/chest` 명령어로 각 플레이어의 개인 엔더상자를 원격으로 열 수 있게 하는 플러그인입니다.

## 기능

- `/chest` 명령어로 자신의 엔더상자 열기
- 엔더상자 열기 및 닫기 소리 재생
- 플레이어별 엔더상자 독립 사용
- 콘솔이 아닌 플레이어만 명령어 사용 가능

## 지원 환경

- Paper API `26.1.2`
- 플러그인 버전 `26.1.0`
- Java `25`

## 설치 방법

1. [Releases](https://github.com/yldst-dev/RemoteEnderChest/releases)에서 JAR 파일을 받습니다.
2. 받은 JAR 파일을 서버의 `plugins` 폴더에 넣습니다.
3. 서버를 재시작합니다.

## 사용 방법

게임 내에서 아래 명령어를 입력하면 자신의 엔더상자가 열립니다.

```text
/chest
```

현재 별도의 권한 노드는 정의되어 있지 않습니다.

## 빌드 방법

이 프로젝트는 Gradle Kotlin DSL을 사용합니다. Gradle이 설치된 환경에서 아래 명령어로 빌드할 수 있습니다.

```bash
gradle build
```

빌드가 완료되면 `build/libs/RemoteEnderChest-26.1.0.jar` 파일이 생성됩니다.
